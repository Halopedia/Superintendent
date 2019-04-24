package superintendent.apis.discord;

public class InsufficientPermissionsException extends Exception {

  private static final long serialVersionUID = 6676653043796350133L;
  
  private final DiscordPermission permission;
  
  public InsufficientPermissionsException(DiscordPermission permission) {
    super("The bot lacks the required permissions to execute this action. "
        + "Requires permission: " + permission.toString());
    this.permission = permission;
  }
  
  public DiscordPermission getPermission() {
    return permission;
  }

}
