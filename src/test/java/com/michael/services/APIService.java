package com.michael.services;

import com.michael.models.Dataset;
import com.michael.models.DatasetInfo;
import com.michael.models.Datasets;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

import java.util.List;

/**
 * Created by maste on 4/16/2017.
 */
public interface APIService {

    @GET("datasets?$inlinecount=allpages")
    Call<Datasets<Dataset>> getDatasets(@Query("$top") int top, @Query("$skip") int skip);

    @GET("datasets?$inlinecount=allpages")
    Call<Datasets<Dataset>> getDatasetsWithSort(@Query("$top") int top, @Query("$skip") int skip, @Query("$orderby") String orderBy);

    @GET("datasets/{id}")
    Call<DatasetInfo> getDatasetInfo(@Path("id") int id);

    @GET("datasets")
    Call<List<Dataset>> getDatasetByCaption(@Query("$filter") String filter);
}
