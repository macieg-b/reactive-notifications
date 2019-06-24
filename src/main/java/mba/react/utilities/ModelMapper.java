package mba.react.utilities;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ModelMapper {

    private final ObjectMapper OBJECT_MAPPER;

    @Autowired
    public ModelMapper(ObjectMapper object_mapper) {
        OBJECT_MAPPER = object_mapper;
    }

    public <T> T convertToView(Object model, Class<T> viewClass) {
        return OBJECT_MAPPER.convertValue(model, viewClass);
    }

    public <T> List<T> convertToView(List<?> models, Class<T> viewClass) {
        List<T> views = new ArrayList<>();
        for (Object model : models) {
            T view = convertToView(model, viewClass);
            views.add(view);
        }
        return views;
    }

    public <T> T convertToModel(Object view, Class<T> modelClass) {
        return OBJECT_MAPPER.convertValue(view, modelClass);
    }

    public <T> List<T> convertToModel(List<?> views, Class<T> modelClass) {
        List<T> models = new ArrayList<>();
        for (Object view : views) {
            T model = convertToModel(view, modelClass);
            models.add(model);
        }
        return models;
    }


}

