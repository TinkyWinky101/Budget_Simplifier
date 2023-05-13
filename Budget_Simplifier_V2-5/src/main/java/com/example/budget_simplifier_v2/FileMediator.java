package com.example.budget_simplifier_v2;

import javafx.collections.ObservableList;
import java.io.File;

public class FileMediator implements FileReaderManager,FileWriterManager {

    private TextFileWriter writer;
    private TextFileReader reader;

    public FileMediator()
    {
        this.writer = new TextFileWriter();
        this.reader = new TextFileReader();
    }

    public void loadFileData(File textfilename, ObservableList<BudgetItem_IF> BudgetList) {
        reader.loadFileData(textfilename, BudgetList);
    }

    public void saveFileData(String textfilename, ObservableList<BudgetItem_IF> BudgetList){
        writer.saveFileData(textfilename, BudgetList);
    }
}
