<?php

include("login.inc.php");
// logindaten

mysql_connect(localhost,$user,$password);
@mysql_select_db($database) or die( "Unable to select database");

$name = mysql_real_escape_string($_GET['name']);
$zeit = mysql_real_escape_string($_GET['zeit']);


if(empty($name) || empty($zeit)) {
	echo "Name oder Zeit leer!";
}
else {
	
	$query = "INSERT INTO b_high VALUES ('','$name','$zeit')";
	mysql_query($query);
header("Status: 301 Moved Permanently"); 
header("Location: http://fapeg.com/bman/high.php?AktuellenEintragHighlighten"); 
}
mysql_close();
?>
