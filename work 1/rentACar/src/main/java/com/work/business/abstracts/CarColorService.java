package com.work.business.abstracts;



import com.work.business.concretes.requests.CreateColorRequest;
import com.work.business.concretes.requests.UpdateColorRequest;
import com.work.business.concretes.responses.GetAllColorResponse;
import com.work.business.concretes.responses.GetByIdColorResponse;

import java.util.List;

public interface CarColorService {
    List<GetAllColorResponse> getAll();
    void delete(int id);

    GetByIdColorResponse getById(int id);

    void add(CreateColorRequest createColorRequest);

    void update(UpdateColorRequest updateColorRequest);

}
