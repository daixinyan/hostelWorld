;
/**
 * Created by darxan on 2017/2/15.
 */

/**
 * global functions
 */
var loginTypeCheckboxEvent = null;
var loginButtonEvent = null;

(function () {

    var loginTypeCheckbox = null;

    $(document).ready(function () {
        loginTypeCheckbox = $('#loginTypeCheckbox').find('input');
        // console.log(loginTypeCheckbox)
    });

    loginButtonEvent = function () {
        alert("listen!!")
    };

    loginTypeCheckboxEvent = function (index) {
        var checkBox = $("#"+index);
        // console.log(checkBox)
        loginTypeCheckbox.attr("checked", false);
        checkBox.prop("checked", 'true');//唯有prop函数可用
    };
})();

