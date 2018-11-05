// Empty constructor
function pruebanro2() {}

// The function that passes work along to native shells
// Message is a string, duration may be 'long' or 'short'
pruebanro2.prototype.show = function(base64, duration, successCallback, errorCallback, base64imagen) {
  var options = {};
  options.base64 = base64;
  options.duration = duration;
  cordova.exec(successCallback, errorCallback, base64imagen, 'pruebanro2', 'show', [options]);
}

// Installation constructor that binds pruebanro2 to window
pruebanro2.install = function() {
  if (!window.plugins) {
    window.plugins = {};
  }
  window.plugins.pruebanro2 = new pruebanro2();
  return window.plugins.pruebanro2;
};
cordova.addConstructor(pruebanro2.install);