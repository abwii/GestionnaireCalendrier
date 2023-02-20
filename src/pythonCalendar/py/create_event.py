import os.path
import json
import pickle
from os import path
from googleapiclient.discovery import build
from google_auth_oauthlib.flow import InstalledAppFlow
from google.auth.transport.requests import Request

SCOPES = ['https://www.googleapis.com/auth/calendar']

CREDENTIALS_FILE = 'src\pythonCalendar\py\json\code_api.json'

def get_calendar_service():
   creds = None
   if os.path.exists('token.pickle'):
       with open('token.pickle', 'rb') as token:
           creds = pickle.load(token)
   if not creds or not creds.valid:
       if creds and creds.expired and creds.refresh_token:
           creds.refresh(Request())
       else:
           flow = InstalledAppFlow.from_client_secrets_file(
               CREDENTIALS_FILE, SCOPES)
           creds = flow.run_local_server(port=0)
       with open('token.pickle', 'wb') as token:
           pickle.dump(creds, token)

   service = build('calendar', 'v3', credentials=creds)
   return service

def main():

   idCalendar = input("Entrez l'id de votre agenda : ('p' si agenda principal)")
   if (idCalendar == 'p') :
      idCalendar = 'primary'
   

   service = get_calendar_service()

   

   if (path.exists("resultatA.json") == True) :
      resultatA = open("resultatA.json", "r")
      print("existe A")
      with open('resultatA.json', 'r') as f:
         dataA = json.load(f)
         print(len(dataA))
   else :
      dataA = None

   if (path.exists("resultatB.json") == True) :
      resultatA = open("resultatB.json", "r")
      print("existe B ")
      with open('resultatB.json', 'r') as f:
         dataB = json.load(f)
         print(len(dataB))
   else :
      dataB = None

   if (path.exists("resultatC.json") == True) :
      resultatA = open("resultatC.json", "r")
      print("existe C")
      with open('resultatC.json', 'r') as f:
         dataC = json.load(f)
         print(len(dataC))
   else :
      dataC = None

   if (path.exists("resultatFeries.json") == True) :
      resultatA = open("resultatA.json", "r")
      print("existe Ferie")
      with open('resultatFeries.json', 'r') as f:
         dataFeries = json.load(f)
         print(len(dataFeries))
   else :
      dataFeries = None

   if (path.exists("resultatA.json") == True) :

      for i in range (0, len(dataA)) :

         a = dataA[i]['summary']
         b = dataA[i]['description']
         c = dataA[i]['start']
         d = dataA[i]['end']

         event_result = service.events().insert(
            calendarId=idCalendar,
            body={
               "summary": a,
               "description": b,
               "start": {"dateTime": c, "timeZone": 'UTC+1'},
               "end": {"dateTime": d, "timeZone": 'UTC+1'},
            }
         ).execute()

   if (path.exists("resultatB.json") == True) :

      for i in range (0, len(dataB)) :

         a = dataB[i]['summary']
         b = dataB[i]['description']
         c = dataB[i]['start']
         d = dataB[i]['end']

         event_result = service.events().insert(
            calendarId=idCalendar,
            body={
               "summary": a,
               "description": b,
               "start": {"dateTime": c, "timeZone": 'UTC+1'},
               "end": {"dateTime": d, "timeZone": 'UTC+1'},
            }
         ).execute()

   if (path.exists("resultatC.json") == True) :

      for i in range (0, len(dataC)) :

         a = dataC[i]['summary']
         b = dataC[i]['description']
         c = dataC[i]['start']
         d = dataC[i]['end']

         event_result = service.events().insert(
            calendarId=idCalendar,
            body={
               "summary": a,
               "description": b,
               "start": {"dateTime": c, "timeZone": 'UTC+1'},
               "end": {"dateTime": d, "timeZone": 'UTC+1'},
            }
         ).execute()

   if (path.exists("resultatFeries.json") == True) :

      for i in range (0, len(dataFeries)) :

         a = dataFeries[i]['summary']
         b = dataFeries[i]['description']
         c = dataFeries[i]['start']
         d = dataFeries[i]['end']

         event_result = service.events().insert(
            calendarId=idCalendar,
            body={
               "summary": a,
               "description": b,
               "start": {"dateTime": c, "timeZone": 'UTC+1'},
               "end": {"dateTime": d, "timeZone": 'UTC+1'},
            }
         ).execute()
   

   print("Succès")

if __name__ == '__main__':
   main()