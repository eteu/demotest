package toto.test.demotest.services;

import org.springframework.stereotype.Service;
import toto.test.demotest.models.Project;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectService implements IProjectService {
    List<Project> listeProject = new ArrayList<>();
    @Override
    public List<Project> all() {
        return listeProject;
    }

    @Override
    public Project byId(Long id) {

        /*Optional<Project> result = listeProject.stream().filter(project -> project.getId() == id).findFirst();
        return result.isPresent() ? result.get() : new Project();*/

        // return listeProject.stream().filter(project -> project.getId() == id).findFirst().orElse(getNewProject());

        //return listeProject.stream().filter(project -> project.getId() == id).findFirst().orElseGet(Project::new);

        return listeProject.stream().filter(project -> project.getId() == id ).findFirst().orElseGet(() -> new Project());
    }

    @Override
    public Project saveOrUpdate(Project projet) {
        /*final Project finalProjet = projet;
        Optional<Project> result = listeProject.stream()
                .filter(project -> project.getId() == finalProjet.getId())
                .findFirst();
        if (result.isPresent()) {
            result.get().setName(projet.getName());
        } else {
            listeProject.add(projet);
            projet.setId(listeProject.size());
        }
        return projet;*/

        return listeProject.stream().filter(project -> projet.getId() == project.getId()).findFirst()
                .map(foundProject -> {
                    foundProject.setName(projet.getName());
                    return foundProject;
                }).orElseGet(() -> {
                    projet.setId(listeProject.stream()
                            .map(Project::getId)
                            .max(Comparator.comparing(Long::longValue))
                            .map(maxValue -> maxValue + 1)
                            .orElse(1L));
                    listeProject.add(projet);
                    return projet;
                });
    }

    @Override
    public void deleteById(Long id) {
        listeProject.remove(byId(id));
    }

    @Override
    public void setListeProject(ArrayList<Project> projects) {
        listeProject = projects;
    }
}
