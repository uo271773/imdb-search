package co.empathy.academy.search.controllers;


import co.empathy.academy.search.responses.SearchDtoResponse;
import co.empathy.academy.search.services.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchController {

    @Autowired
    private SearchService searchService;

    @GetMapping("/search")
    public SearchDtoResponse search(@RequestParam String query) {
        String queryOk = searchService.getQuery(query);
        String clusterName = searchService.getClusterName();
        return new SearchDtoResponse(queryOk, clusterName);
    }

}
