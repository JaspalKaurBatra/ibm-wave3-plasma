package com.stackroute.plasma.service;

import com.stackroute.plasma.domain.Url;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;


@Service
public interface DocumentService {
//   Document getHtmlContent() throws IOException;

//Url getDocument() throws IOException;
   //String getHtml(String singleUrl) throws IOException;
   public List<Url> getHtml() throws IOException;
}
