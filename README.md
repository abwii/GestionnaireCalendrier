1 - Créer une base de données du nom de "calendrier" <br>
2 - Importer le fichier "ExportCalendrier.sql" <br>
3 - Installer Python <br>
4 - ouvrir une cmd et écrire "pip install --upgrade google-api-python-client google-auth-httplib2 google-auth-oauthlib"
5 - Pour Java : Sur votre IDE, veuillez vous assurer que dans vos modules les fichier présent dans lib (jcalendar1-4.jar, json-simple-1.1.jar, jyhton-stndalone-2.7.3.jar et mysql-connector-java-5.1.48.jar). Si ils ne sont pas présent, veuillez les ajouter. <br>
 <br>
Fonctionnement : <br>
- Ouvrir le fichier "MyCalendar.jar" <br>
- Séléctionner des topics <br>
- Appuyer sur "Exporter" <br>
- Executer le fichier "create_event.py"¹ dans "GestionnaireCalendrier/src/pythonCalendar/py/" <br>
- Suivre les informations de Google <br>
- Enjoy 🎈<br>
<br>
¹Important : par défaut, l'ajout d'evenement se fait dans l'agenda principal. Pour changer cela, créez un agenda sur Google Calendar, récupérez son id et mettez le dans la console après avoir executé le script.
