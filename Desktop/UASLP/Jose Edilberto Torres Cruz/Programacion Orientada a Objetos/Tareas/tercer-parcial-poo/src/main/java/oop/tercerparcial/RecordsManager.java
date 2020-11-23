package oop.tercerparcial;

import java.io.*;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class RecordsManager {
    File recordsFile;


    public RecordsManager(File recordsFile) {
        this.recordsFile = recordsFile;
    }

    public void save(GameRecord record)  {

        if (record.getPlayerName() == null)
            throw new InvalidPlayerNameException();

        if (record.getPlayerName().equals("")) {
            throw new InvalidPlayerNameException();
        }


        if (record.getScore() < 0) {
            throw new NegativeScoreException();
        }

        try (FileWriter writer = new FileWriter(recordsFile.getAbsoluteFile(),true)) {
            writer.write(record.getScore() + ","+ record.getPlayerName()+ System.lineSeparator());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public List<GameRecord> list() {
        List<GameRecord> records = new ArrayList<>();
        List<String> lines;

        try{
            lines = Files.readAllLines(Paths.get(recordsFile.getAbsolutePath()));
            Iterator<String> linesIterator = lines.iterator();
            while (linesIterator.hasNext()) {
                String csvLine = linesIterator.next();

                String []parts = csvLine.split(",");

                GameRecord record = new GameRecord(Integer.parseInt(parts[0]),parts[1]);
                records.add(record);

            }
        } catch (IOException e){ }
        sort(records);
        return records;
    }

    public static void sort(List<GameRecord> records){
        for(int i = 0; i < records.size();i++){
            for (int j =0; j< records.size(); j++) {
                if (records.get(i).getScore() >records.get(j).getScore()) {

                    int aux = records.get(i).getScore();
                    String saux = records.get(i).getPlayerName();

                    records.get(i).setScore(records.get(j).getScore());
                    records.get(i).setPlayerName(records.get(j).getPlayerName());

                    records.get(j).setScore(aux);
                    records.get(j).setPlayerName(saux);
                }
            }
        }
    }
}
