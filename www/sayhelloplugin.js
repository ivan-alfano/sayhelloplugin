var sayhelloplugin = {
    createEvent: function(name, successCallback, errorCallback) {
        cordova.exec(
            successCallback, // success callback function
            errorCallback, // error callback function
            'SayHelloPlugin', // mapped to our native Java class called "SayHelloPlugin"
            'sayhello', // with this action name
            [name]    // and this array of custom arguments to create our entry
        ); 
    }
}
module.exports = sayhelloplugin;
