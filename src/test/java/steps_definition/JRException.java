package steps_definition;

public class JRException
    extends AssertionError
{
    public JRException( final String message,
                        final Throwable cause )
    {
        super( message,
               cause );
    }
}
