package com.example.demo.request;

import javax.validation.constraints.NotBlank;

public class SearchRequest {
  @NotBlank
  private String keyword;

  public String getKeyword() {
    return keyword;
  }

  public void setKeyword(@NotBlank String keyword) {
    this.keyword = keyword;
  }
}
