package com.example.budget_simplifier_v2;

import javafx.collections.ObservableList;

public class FileMediator implements FileReaderManager,FileWriterManager {

    private TextFileWriter writer;
    private TextFileReader reader;

    public FileMediator(TextFileWriter writer, TextFileReader reader){
        this.writer = writer;
        this.reader = reader;
    }

    public void registerFileReader(TextFileReader reader){
        reader.addReaderManager(this::loadFileData);
    }

    public void registerFileWriter(TextFileWriter writer){
        writer.addWriterManager(this::saveFileData);
    }

    public void loadFileData(String textfilename, ObservableList<IncomeItem> IncomeList, ObservableList<ExpenseItem> ExpenseList) {
        reader.loadFileData(textfilename, IncomeList, ExpenseList);
    }

    public void saveFileData(String textfilename, ObservableList<IncomeItem> IncomeList, ObservableList<ExpenseItem> ExpenseList){
        writer.saveFileData(textfilename, IncomeList, ExpenseList);
    }
}
