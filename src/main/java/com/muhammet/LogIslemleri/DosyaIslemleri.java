package com.muhammet.LogIslemleri;

import java.io.*;
import java.util.Optional;
import java.util.UUID;

public class DosyaIslemleri {

    public void createLog(Log log){
        try{
            String fileName = UUID.randomUUID().toString();
            FileOutputStream file = new FileOutputStream("c:/LogData/"+fileName+".log");
            ObjectOutputStream logStream = new ObjectOutputStream(file);
            logStream.writeObject(log);
            logStream.close();
        }catch (Exception exception){

        }
    }

    public Optional<Log> getLogFile(String logFileUuid){
        try{
            FileInputStream file = new FileInputStream("c:/LogData/"+logFileUuid+".log");
            ObjectInputStream logStream = new ObjectInputStream(file);
            Log log = (Log) logStream.readObject();
            logStream.close();
            return Optional.of(log);
        }catch (Exception exception){
            return Optional.empty();
        }
    }
}
