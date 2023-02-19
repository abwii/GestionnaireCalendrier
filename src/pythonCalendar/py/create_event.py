from datetime import datetime, timedelta
from cal_setup import get_calendar_service


def main():
   service = get_calendar_service()

   #requête api
   event_result = service.events().insert(calendarId='primary',
       body={
           "summary": 'Fête de noel',
           "description": 'Fêtes des neiges',
           "start": {"dateTime": "2023-02-20T10:00:00+01:00", "timeZone": 'UTC+1'},
           "end": {"dateTime": "2023-02-20T10:00:00+01:00", "timeZone": 'UTC+1'},
       }
   ).execute()
   #fin requête

   print("Succès")

if __name__ == '__main__':
   main()