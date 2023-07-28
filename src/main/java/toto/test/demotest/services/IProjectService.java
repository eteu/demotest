package toto.test.demotest.services;

import toto.test.demotest.models.Project;

import java.util.ArrayList;
import java.util.List;

public interface IProjectService {
    List<Project> all();
    Project byId(Long id);
    Project saveOrUpdate(Project projet);
    void deleteById(Long id);
    void setListeProject(ArrayList<Project> projects);
}
