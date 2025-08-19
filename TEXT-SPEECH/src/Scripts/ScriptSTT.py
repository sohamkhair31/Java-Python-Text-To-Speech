import speech_recognition as sr
from py4j.java_gateway import JavaGateway
import pyttsx3 as engine;

def takeCommand():
    
    eng = engine.Engine()
    eng.setProperty('voices',1)
    eng.say("Speak : ")
    eng.runAndWait()
    r = sr.Recognizer()
    with sr.Microphone() as source:
        print("Listening...")
        r.pause_threshold = 1
        audio = r.listen(source)

    try:
        print("Recognizing...")    
        query = r.recognize_google(audio, language='en-in')
        print(f"User said: {query}\n")

    except Exception as e:
        # print(e)    
        print("Say that again please...")  
        return "None"
    return query

if __name__=="__main__":
    gateway = JavaGateway()
    app = gateway.entry_point
    str = takeCommand()
    app.takeAudio(str)