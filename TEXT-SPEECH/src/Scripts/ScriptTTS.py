import pyttsx3 as speech
from py4j.java_gateway import JavaGateway 
from . import _espeak


def Speak(str):
    engine = speech.Engine()
    engine.say(str)
    engine.runAndWait()

if __name__ =="__main__":
    gateway = JavaGateway()
    app = gateway.entry_point
    str = app.getSTR()
    Speak(str)
    