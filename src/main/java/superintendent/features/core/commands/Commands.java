package superintendent.features.core.commands;

import java.util.HashSet;
import java.util.Set;

import superintendent.apis.common.ApiPermission;
import superintendent.features.Feature;
import superintendent.features.FeatureCategory;

public class Commands implements Feature {

  @Override
  public String getName() {
    return "Commands";
  }

  @Override
  public int getVersionNum() {
    return 0;
  }

  @Override
  public int getPatchNum() {
    return 1;
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.CORE;
  }

  @Override
  public String getDescription() {
    return "This feature allows users to run commands. For a list of all"
        + " commands, run the commandlist command. For help with a given"
        + " command, run the help followed by the name of the command.";
  }

  @Override
  public boolean isEnabledByDefault() {
    return true;
  }
  
  @Override
  public boolean canBeDisabled() {
    return false;
  }

  @Override
  public Set<ApiPermission> getMinPermissions() {
    return new HashSet<>();
  }

}
