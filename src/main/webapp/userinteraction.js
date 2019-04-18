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

// Toggle between showing and hiding the sidebar, and add overlay effect
function w3_open() {
    // Get the Sidebar
    var mySidebar = document.getElementById("mySidebar");
    // Get the DIV with overlay effect
    var overlayBg = document.getElementById("myOverlay");
  if (mySidebar.style.display === 'block') {
    mySidebar.style.display = 'none';
    overlayBg.style.display = "none";
  } else {
    mySidebar.style.display = 'block';
    overlayBg.style.display = "block";
  }
}

// Close the sidebar with the close button
function w3_close() {
    // Get the Sidebar
    var mySidebar = document.getElementById("mySidebar");
    // Get the DIV with overlay effect
    var overlayBg = document.getElementById("myOverlay");
  mySidebar.style.display = "none";
  overlayBg.style.display = "none";
}
