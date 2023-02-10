package net.jakim.abilities;

import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.screenplay.Ability;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.RefersToActor;

import java.sql.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Slf4j
public class QueryTheDB implements Ability, RefersToActor {


    private Actor actor;

    public void execute(String message) {
        log.info("Actor {} run query {}", actor.getName(), message);
    }

    public List<Map<String, String>> executeQuery(String message) {
        log.info("Actor {} run query {}", actor.getName(), message);

        try (Connection con = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/db",
                        "root",
                        "pass")) {

            return executeStatement(con, message);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private List<Map<String, String>> executeStatement(Connection con, String message) {
        try (PreparedStatement pstm = con.prepareStatement(message)) {
            return getResultFromStatement(pstm);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private List<Map<String, String>> getResultFromStatement(PreparedStatement pstm) {
        List<Map<String, String>> result;
        try (ResultSet resultSet = pstm.executeQuery()) {
            result = new LinkedList<>();
            ResultSetMetaData rsmd = resultSet.getMetaData();

            int columnsNumber = rsmd.getColumnCount();

            while (resultSet.next()) {
                Map<String, String> record = new HashMap<>();
                for (int i = 1; i <= columnsNumber; i++) {
                    record.put(rsmd.getColumnName(i), resultSet.getString(i));
                }
                result.add(record);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return result;
    }


    public static QueryTheDB as(Actor actor) {
        if (actor.abilityTo(QueryTheDB.class) == null) {
            throw new RuntimeException("The actor " + actor.getName() + " does not have ability to query the DB");
        }

        return actor.abilityTo(QueryTheDB.class).asActor(actor);
    }

    @Override
    public <T extends Ability> T asActor(Actor actor) {
        this.actor = actor;
        return (T) this;
    }
}
