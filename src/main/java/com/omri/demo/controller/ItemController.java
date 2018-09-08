package com.omri.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.omri.demo.domain.Item;
import com.omri.demo.domain.ItemRepository;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/item")
public class ItemController {
	
	@Autowired
	private ItemRepository itemRepository;

	/**
	 * Fetch a list of items
	 * @return a list of items
	 */
    @RequestMapping(path="/all", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "Fetch all items")
    @ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Success", response = Item.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Server Error")}) 

    public List<Item> people() {
    	List<Item> items = (List<Item>) itemRepository.findAll();
    	
    	return items;
    }
    
    
    /**
     * Finds a items by <code>id</code>
     * 
     * @param id items id
     * 
     * @return the {@link Item} object
     */
    @RequestMapping(path = "/{id}", 
    				method = RequestMethod.GET)
    @ApiOperation(value = "Fetch a item")
    public Optional<Item> item(@PathVariable Long id) {
    	return itemRepository.findById(id);
    }
    
    /**
     * Adds a item
     * 
     * @param item
     * @return
     */
    @RequestMapping(path = "/add",
    				method = RequestMethod.POST,
    				 consumes =  MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Add a item")
    public Item add(@RequestBody Item item) {
    	Item savedItem =  itemRepository.save(item);
    	
    	return savedItem;
    }
    
    /**
     * Updates the item
     * 
     * @param item
     * @return
     */
    @RequestMapping(path = "/update",
    				method = RequestMethod.PUT)
    @ApiOperation(value = "Update a item")
    public Item update(@RequestBody Item item) {
    	Item saveditem =  itemRepository.save(item);
    	return saveditem;
    }
    
    
    /**
     * Deletes item identified with <code>id</code>
     * @param id
     */
    @RequestMapping(path = "/{id}", 
			method = RequestMethod.DELETE)
    @ApiOperation(value = "Delete a item")
    public void delete(@PathVariable Long id) {
    	itemRepository.deleteById(id);
    }

}
