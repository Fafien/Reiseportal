/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function() {
    
    $(function() {
        $("#datum1").datepicker({
            dateFormat: "dd.mm.yy",
            changeMonth: true,
            changeYear: true,
            firstDay: 1,
            minDate: 0,
            showOtherMonths: true,
            selectOtherMonths: true,
            dayNamesMin: ['So', 'Mo', 'Di', 'Mi', 'Do', 'Fr', 'Sa'],
            monthNames: ['Januar', 'Februar', 'März', 'April', 'Mai', 'Juni', 'Juli', 'August', 'September', 'Oktober',  'November', 'Dezember']
        });
    });
    
    $(function() {
        $("#datum2").datepicker({
            dateFormat: "dd.mm.yy",
            changeMonth: true,
            changeYear: true,
            firstDay: 1,
            minDate: 0,
            showOtherMonths: true,
            selectOtherMonths: true,
            dayNamesMin: ['So', 'Mo', 'Di', 'Mi', 'Do', 'Fr', 'Sa'],
            monthNames: ['Januar', 'Februar', 'März', 'April', 'Mai', 'Juni', 'Juli', 'August', 'September', 'Oktober',  'November', 'Dezember']
        });
    });
});
