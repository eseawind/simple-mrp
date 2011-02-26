cd ".\simple-mrp-ejb\build\classes"
jar cvf "..\..\..\simple-mrp-war\lib\simple-ejb-itnf.jar" simplemrp/facade/*.class simplemrp/entity/*.class simplemrp/util/*.class simplemrp/to/*.class
cd "../../../"