/**
 * JS获取今天是本月第几周、本月共几周、本月有多少天、是今年的第几周、是今年的第几天
 *      function getDatIndexInYear () {
            document.getElementById('dateIndexInYear').innerText = (document.getElementById('date').value + '').weekIndexInYear();
        }
        function getWeekIndexInYear () {
            document.getElementById('weekIndexInYear').innerText = (document.getElementById('date').value + '').dateIndexInYear();
        }
        function getWeekInMonthCount () {
            document.getElementById('count').innerText = (document.getElementById('date').value + '').weekInMonthCount();
        }
        function getWeekIndexInMonth () {
            document.getElementById('indexInMonth').innerText = (document.getElementById('date').value + '').weekIndexInMonth();
        }
 */

// 获取某年某月的有多少周
String.prototype.weekInMonthCount = function () {
    var date = new Date((new Date(this).setDate(1)) || (new Date()).setDate(1));
    var firstWeekDate = 1;// 默认第一周是本月1号  为了模拟本月1号是否为本月第1周的判断
    if (date.getDay() === 1) { // 判断1号是周一
        firstWeekDatek = 1;
    } else if (date.getDay() === 0) { // 判断1号是周日
        firstWeekDate = 8 - 7 + 1;
    } else { // 判断1号是周二至周六之间
        firstWeekDate = 8 - date.getDay() + 1;
    }
    date.setMonth(date.getMonth()+1);
    date.setDate(0);
    var monthHasDays = date.getDate();// 本月天数
    monthHasDays = date.getDate() - firstWeekDate + 1;
    var hasWeek = Math.ceil(monthHasDays/7); // 计算本月有几周
    return hasWeek;
};
// 获取今天是今年的第几周
String.prototype.weekIndexInYear = function () {
    var nowDate = new Date(this != '' ? this : new Date());
    var initTime = new Date(this != '' ? this : new Date());
    initTime.setMonth(0); // 本年初始月份
    initTime.setDate(1); // 本年初始时间
    var differenceVal = nowDate - initTime ; // 今天的时间减去本年开始时间，获得相差的时间
    var todayYear = Math.ceil(differenceVal/(24*60*60*1000)); // 获取今天是今年第几天
    var index = Math.ceil(todayYear/7); // 获取今天是今年第几周
    return index;
};
// 获取今天是今年的第几天
String.prototype.dateIndexInYear = function () {
    var nowDate = new Date(this != '' ? this : new Date());
    var initTime = new Date(this != '' ? this : new Date());
    initTime.setMonth(0); // 本年初始月份
    initTime.setDate(1); // 本年初始时间
    var differenceVal = nowDate - initTime ; // 今天的时间减去本年开始时间，获得相差的时间
    return Math.ceil(differenceVal/(24*60*60*1000));
};
// 获取今天是第几周
String.prototype.weekIndexInMonth = function () {
    var date = new Date(this.trim() != '' ? this : new Date());
    var dateStart = new Date((new Date(this.trim() != '' ? this : new Date()).setDate(1))); // 本月初
    var firstWeek = 1;
    if (dateStart.getDay() === 1) {
        firstWeek = 1;
    } else if (dateStart.getDay() === 0) {
        firstWeek = 8 - 7 + 1;
    } else {
        firstWeek = 8 - dateStart.getDay() + 1;
    }
    var weekIndex = 1;
    var c = date.getDate();
    if (date.getDay() === 1 && date.getDate() < 7) {
        weekIndex = 1;
    } else if (c < firstWeek ) {
        weekIndex = -1;
    } else {
        if (c < 7) {
            weekIndex = Math.ceil(c/7);
        } else {
            c =  c - firstWeek + 1;
            if (c%7 === 0) {
                if (dateStart.getDay() !== 6) {
                    weekIndex = c/7;
                } else {
                    weekIndex = c/7 + 1;
                }
            } else {
                weekIndex = Math.ceil(c/7);
            }
        }
    }
    return weekIndex;
};
