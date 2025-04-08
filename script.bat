@echo off

REM Définir les variables pour les chemins
set "work=C:\Users\Mario\Documents\S4\WEB DYNAMIQUE\Prepa_exam"
set "work_dir=."
set "src=%work_dir%\src"
set "lib=%work_dir%\lib"
set "build=%work_dir%\build"
set "front=%src%\Front"
set "web_xml=%work_dir%\src\main\webapp\WEB-INF\web.xml"
set "web_apps=C:\Users\Mario\Documents\apache-tomcat-10.1.28\webapps"
set "war_name=ETU003229"

:: Effacer le dossier [build] s'il existe déjà
if exist "%build%" (
    rd /s /q "%build%"
)

:: Création de la structure des dossiers dans [build]
mkdir "%build%\WEB-INF\lib"
mkdir "%build%\WEB-INF\classes"


:: Copie de web.xml vers build/WEB-INF/
xcopy /y "%web_xml%" "%build%\WEB-INF"

:: Copier les fichiers .jsp dans le répertoire temporaire
xcopy /y "%front%\*.jsp" "%build%"
:: Copier les dossiers assets et images dans le répertoire temporaire
xcopy /s /y "%lib%" "%build%\WEB-INF\lib"

:: Copier les fichiers de configuration dans WEB-INF/classes si nécessaire
:: Remarquez que %config_xml% n'est pas défini dans le script original, donc il est soit à ajouter soit à retirer
:: Si vous avez des fichiers de configuration, vous pouvez définir leur emplacement ici
:: xcopy /y "%config_xml%" "%build%\WEB-INF\classes"

for /r "%src%" %%f in (*.java) do copy "%%f" "%build%\WEB-INF\classes"

cd "%build%\WEB-INF\classes"

javac -d . *.java

del /q *.java

cd ..
cd ..

jar -cvf "%work_dir%\%war_name%.war" *
cd %work_dir%

:: Effacer le fichier.war dans [web_apps] s'il existe
if exist "%web_apps%\%war_name%.war" (
    del /f /q "%web_apps%\%war_name%.war"
)

:: Copier le fichier.war vers [web_apps]
copy /y "%work_dir%\%war_name%.war" "%web_apps%"

del /f /q "%work_dir%\%war_name%.war"

echo Déploiement terminé.

pause
