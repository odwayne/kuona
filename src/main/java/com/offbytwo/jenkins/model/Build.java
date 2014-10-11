/*
 * Copyright (c) 2013 Rising Oak LLC.
 *
 * Distributed under the MIT license: http://opensource.org/licenses/MIT
 */

package com.offbytwo.jenkins.model;

import kuona.JenkinsClient;

import java.io.IOException;

public class Build extends BaseModel {
    int number;
    String url;

    public Build() {
    }

    public Build(Build from) {
        this(from.getNumber(), from.getUrl());
    }
    public Build(Build from, JenkinsClient client) {
        this(from.getNumber(), from.getUrl());
        setClient(client);
    }

    public Build(int number, String url) {
        this.number = number;
        this.url = url;
    }

    public int getNumber() {
        return number;
    }

    public String getUrl() {
        return url;
    }

    public BuildWithDetails details() throws IOException {
        return client.get(url, BuildWithDetails.class);
    }
}
