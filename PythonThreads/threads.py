import threading
import time
import random

"""
ARGS & VARS
"""
laps=10
delay=0.3
sleepTime=3
threads = []
waitLocks= {}

for lock in range(laps):
    waitLocks[lock]=threading.Condition()


"""
TURTLE
"""
def turtle(laps,delay):
    for counter in range(laps):
        print threading.currentThread().getName()+"["+str(counter)+"]"
        time.sleep(delay);
        waitLocks[lock].acquire()
        waitLocks[lock].notifyAll()
        waitLocks[lock].release()
    return
"""
HARE
"""
def hare(laps,sleepTime):
    slept=0
    for counter in range(laps):
        print threading.currentThread().getName()+"["+str(counter)+"]"
        randomDice=random.randint(1, 100)
        if slept == 0 and randomDice > 80 :
            print threading.currentThread().getName()+"[zzzZZZZ]"
            '''time.sleep(sleepTime)'''
            waitLocks[lock].acquire()
            sleepQuality=waitLocks[lock].wait(sleepTime)
            waitLocks[lock].release()
            slept=1

            if not sleepQuality :
                hareStatus="woken Up"
            else:
                hareStatus="God morning sunshine"
            print threading.currentThread().getName()+"["+hareStatus+"]"
    return

"""
MAIN LOOPS
"""


for i in range(5):
    turtleName="turtle"+str(i)
    t = threading.Thread(name=turtleName,target=turtle,args=(laps,delay))
    t.start()

for i in range(5):
    hareName="hare"+str(i)
    t = threading.Thread(name=hareName,target=hare,args=(laps,sleepTime))
    threads.append(t)
    t.start()
