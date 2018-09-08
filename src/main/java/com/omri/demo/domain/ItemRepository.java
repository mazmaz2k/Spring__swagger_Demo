package com.omri.demo.domain;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.omri.demo.domain.Item;


public interface ItemRepository extends PagingAndSortingRepository<Item, Long> {

}
