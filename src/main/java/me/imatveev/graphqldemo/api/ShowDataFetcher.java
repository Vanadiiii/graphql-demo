package me.imatveev.graphqldemo.api;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import graphql.com.google.common.base.Strings;
import lombok.RequiredArgsConstructor;
import me.imatveev.graphqldemo.domain.ShowService;
import me.imatveev.graphqldemo.domain.entity.Show;

import java.util.List;

@DgsComponent
@RequiredArgsConstructor
public class ShowDataFetcher {
    private final ShowService showService;

    @DgsQuery
    public List<Show> shows(@InputArgument String titleFilter) {
        return Strings.isNullOrEmpty(titleFilter)
                ? showService.findAll()
                : showService.findByTitleFilter(titleFilter);
    }

    @DgsQuery
    public Show show(@InputArgument String id) {
        return showService.findById(id);
    }
}
