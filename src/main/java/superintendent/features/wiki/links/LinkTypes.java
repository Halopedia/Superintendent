package superintendent.features.wiki.links;

public enum LinkTypes implements LinkType {

  NORMAL(
      "Wiki",
      "\\[\\[[^\\[\\]\\{\\}\\n]*\\]\\]",
      "\\|.*|\\[|\\]",
      ""),
  TEMPLATE(
      "Template",
      "\\{\\{[^\\[\\]\\{\\}\\n]*\\}\\}",
      "\\|.*|\\{|\\}",
      "Template");

  private final String name;
  private final String search;
  private final String cleanup;
  private final String namespace;

  private LinkTypes(String name, String search, String cleanup,
      String namespace) {
    this.name = name;
    this.search = search;
    this.cleanup = cleanup;
    this.namespace = namespace;
  }
  
  @Override
  public String getName() {
    return name;
  }

  @Override
  public String getSearchRegex() {
    return search;
  }

  @Override
  public String getCleanupRegex() {
    return cleanup;
  }

  @Override
  public String getDefaultNamespace() {
    return namespace;
  }
}