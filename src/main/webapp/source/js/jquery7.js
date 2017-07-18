function changeGoodInf(){
    var spanValue = $("#GoodInf").text();
    $("#GoodInfInput").val(spanValue);
    $("#GoodInfInput").show();
    $("#GoodInf").hide();
    $("#changeGoodInf").hide();
    $("#GoodInfChangeOK").show();
}
$("#GoodInfChangeOK").click(function(){
    var inputValue = $("#GoodInfInput").val();
    $("#GoodInf").text(inputValue);
    $("#GoodInfInput").hide();
    $("#GoodInf").show();
    $("#changeGoodInf").show();
    $("#GoodInfChangeOK").hide();
});
