app = (function () {

    function getList(){
        var num = $("#get").val()
        var promise = $.get({
                url: "/hello%"+num,
                contentType: "application/json"
            });
            promise.then(function(data){
               console.log("paso")
            }, function(error) {
                console.log("error")
            });
    }


    return{
        getList:getList,
    }
})();