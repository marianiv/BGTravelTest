package services;

import models.Category;
import models.Transport;
import repo.DBMainRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TransportService {

    public List<Transport> load(String categoryName, String transportName) {

        List<Transport> transportList = DBMainRepo.getTransportList();
        List<Transport> result = new ArrayList<>();

        if (categoryName == null || categoryName.trim().isEmpty()) {
            result = transportList;
        } else {
            for (Transport transport : transportList) {
                for (Category category : transport.getCategories()) {
                    if (category.getTitle().equals(categoryName)) {
                        result.add(transport);
                        break;
                    }
                }
            }
        }
            if (transportName != null && !transportName.trim().isEmpty()) {
                return result.stream().filter(m -> m.getTitle().contains(transportName)).collect(Collectors.toList());
            }
            return result;
        }

    }
