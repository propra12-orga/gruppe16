<?php

include("login.inc.php");
// logindaten

mysql_connect(localhost,$user,$password);
@mysql_select_db($database) or die( "Unable to select database");
$query="SELECT * FROM b_high ORDER BY zeit ASC";
$result=mysql_query($query);

$num=mysql_numrows($result);
if(isset($_GET['AktuellenEintragHighlighten'])) {
	$query2="SELECT * FROM b_high ORDER BY id DESC";
	$result2=mysql_query($query2);
	$aid = mysql_result($result2,0,"id");
}
mysql_close();

echo	"<h1>Highscore</h1><table>
		<tr><th>platz</th><th>name</th><th>zeit (sekunden)</th></tr>";


$i=0;
while ($i < $num) {
	$platz= htmlspecialchars($i+1);
	$name=htmlspecialchars(mysql_result($result,$i,"name"));
	$zeit=htmlspecialchars(mysql_result($result,$i,"zeit"));
	$id=htmlspecialchars(mysql_result($result,$i,"id"));
	echo "<tr";
	if($aid==$id) {echo " style='background-color:yellow'";}
	echo "><td>$platz</td><td>$name</td><td>$zeit</td></tr>";
	$i++;
}
echo "</table>";
?>