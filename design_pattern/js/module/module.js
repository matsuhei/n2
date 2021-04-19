const modulePattern = {

  property: "someValue",

  config: {
    useCaching: true,
    language: "jp"
  },
  log: () =>  {
    console.log("module pattern");
  },
  showMyConfig: () => {
    console.log("Caching is: " + (this.config.useCaching ? "enabled" : "disabled"));
  },
  updateMyConfig: (newConfig) => {

    if (typeof newConfig === "object") {
      this.config = newConfig;
      console.log(this.config.language);
    }
  },
  getMyConfig: () => {
    return this.config;
  }
};

module.exports = modulePattern;
