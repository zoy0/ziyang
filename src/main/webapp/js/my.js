function getQueryVariable(variable)
{

    var query = window.location.search.substring(1);

    var vars = query.split("&");

    for (var i=0;i<vars.length;i++) {

        var pair = vars[i].split("=");

        if(pair[0] == variable){return pair[1];}

    }

    return(false);

}

function timestampToTime(timestamp) {
    var date = new Date(timestamp);//时间戳为10位需*1000，时间戳为13位的话不需乘1000
    var Y = date.getFullYear() + '-';
    var M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '-';
    var D = date.getDate() + ' ';
    var h = date.getHours() + ':';
    var m = date.getMinutes() + ':';
    var s = date.getSeconds();
    return Y+M+D+h+m+s;
}