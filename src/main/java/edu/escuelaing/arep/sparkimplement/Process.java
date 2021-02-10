package edu.escuelaing.arep.sparkimplement;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public interface Process {
    public String handle (String path, HttpRequest req, HttpResponse res);
}
