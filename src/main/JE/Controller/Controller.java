package Controller;

import Repository.*;

import java.util.ArrayList;
import java.util.Objects;

public class Controller<ModelType> {
    private Repository repository;
    private ArrayList<ModelType> modelList;

    public Controller(Repository repository) {
        this.repository = repository;
        modelList = (ArrayList<ModelType>) repository.load();
    }

    public int getIndexElement(ModelType element) {
        return modelList.indexOf(element);
    }

    public ArrayList<Integer> getIndexElement(ArrayList<ModelType> elements){
        ArrayList<Integer> indices = new ArrayList<>();
        for(ModelType element : elements){
            indices.add(getIndexElement(element));
        }
        return indices;
    }

    public ArrayList<ModelType> getElement(ArrayList<Integer> indeces) {
        ArrayList<ModelType> elements = new ArrayList<>();
        for(int index : indeces){
            elements.add(getElement(index));
        }
        return elements;
    }

    public void setElement(ModelType model) {
        modelList.add(model);
    }

    public void setElement(int index, ModelType model) throws IndexOutOfBoundsException {
        modelList.set(index, model);
    }

    public ArrayList<ModelType> getElement() {
        return modelList;
    }

    public ModelType getElement(int id) throws IndexOutOfBoundsException {
        return modelList.get(id);
    }

    public void removeElement(int id) throws IndexOutOfBoundsException {
        modelList.remove(id);
    }

    public void save(){
        repository.save((ArrayList<Objects>) modelList);
    }
}
