package me.imatveev.graphqldemo.api;

import com.netflix.graphql.dgs.DgsQueryExecutor;
import com.netflix.graphql.dgs.autoconfig.DgsAutoConfiguration;
import me.imatveev.graphqldemo.domain.ShowService;
import me.imatveev.graphqldemo.domain.entity.Show;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = {DgsAutoConfiguration.class, ShowDataFetcher.class})
class ShowDataFetcherTest {

    @Autowired
    private DgsQueryExecutor queryExecutor;
    @MockBean
    private ShowService showService;

    @Test
    void shows() {
        when(showService.findAll())
                .thenReturn(List.of(
                        new Show("Stranger Things", 2016),
                        new Show("Ozark", 2017),
                        new Show("The Crown", 2016)
                ));

        List<String> titles = queryExecutor.executeAndExtractJsonPath(
                " { shows { title releaseYear }}",
                "data.shows[*].title"
        );

        assertTrue(titles.contains("Ozark"));
    }
}