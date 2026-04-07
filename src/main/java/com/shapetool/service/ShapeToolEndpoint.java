package com.shapetool.service;

import com.shapetool.gen.*;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class ShapeToolEndpoint {
    private static final String NAMESPACE_URI = "http://www.shapetool.com/gen";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "circleAreaRequest")
    @ResponsePayload
    public CircleAreaResponse getCircleArea(@RequestPayload CircleAreaRequest request) {
        CircleAreaResponse response = new CircleAreaResponse();
        double area = Math.PI * Math.pow(request.getRadius(), 2);
        response.setArea(area);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "squareAreaRequest")
    @ResponsePayload
    public SquareAreaResponse getSquareArea(@RequestPayload SquareAreaRequest request) {
        SquareAreaResponse response = new SquareAreaResponse();
        double area = Math.pow(request.getSide(), 2);
        response.setArea(area);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "rectangleAreaRequest")
    @ResponsePayload
    public RectangleAreaResponse getRectangleArea(@RequestPayload RectangleAreaRequest request) {
        RectangleAreaResponse response = new RectangleAreaResponse();
        double area = request.getLength() * request.getWidth();
        response.setArea(area);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "parallelogramAreaRequest")
    @ResponsePayload
    public ParallelogramAreaResponse getParallelogramArea(@RequestPayload ParallelogramAreaRequest request) {
        ParallelogramAreaResponse response = new ParallelogramAreaResponse();
        double area = request.getBase() * request.getHeight();
        response.setArea(area);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "triangleAreaRequest")
    @ResponsePayload
    public TriangleAreaResponse getTriangleArea(@RequestPayload TriangleAreaRequest request) {
        TriangleAreaResponse response = new TriangleAreaResponse();
        double area = 0.5 * request.getBase() * request.getHeight();
        response.setArea(area);
        return response;
    }
}
