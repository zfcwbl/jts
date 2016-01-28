/*
 * The JTS Topology Suite is a collection of Java classes that
 * implement the fundamental operations required to validate a given
 * geo-spatial data set to a known topological specification.
 * 
 * Copyright (C) 2016 Vivid Solutions
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * (http://www.eclipse.org/legal/epl-v10.html), and the Vivid Solutions BSD
 * License v1.0 (found at the root of the repository).
 * 
 */

package com.vividsolutions.jts.io.geojson;

import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.io.ParseException;

import test.jts.GeometryTestCase;


public class GeoJsonTest extends GeometryTestCase {

  public GeoJsonWriter geoJsonWriter;

  public GeoJsonReader geoJsonReader;

  public GeoJsonTest(String name) {
    super(name);
  }

  @Override
  public void setUp() throws Exception {

    this.geoJsonWriter = new GeoJsonWriter();
    this.geoJsonReader = new GeoJsonReader();
  }

  public void testPoint() throws ParseException {
    runTest("POINT (1 2)");
  }

  public void testLineString() throws ParseException {
    runTest("LINESTRING (1 2, 10 20, 100 200)");
  }

  public void testPolygon() throws ParseException {
    runTest("POLYGON ((0 0, 100 0, 100 100, 0 100, 0 0))");
  }

  public void testPolygonWithHole() throws ParseException {
    runTest("POLYGON ((0 0, 100 0, 100 100, 0 100, 0 0), (1 1, 1 10, 10 10, 10 1, 1 1) )");
  }

  public void testMultiPoint() throws ParseException {
    runTest("MULTIPOINT ((0 0), (1 4), (100 200))");
  }

  public void testMultiLineString() throws ParseException {
    runTest("MULTILINESTRING ((0 0, 1 10), (10 10, 20 30), (123 123, 456 789))");
  }

  public void testMultiPolygon() throws ParseException {
    runTest("MULTIPOLYGON ( ((0 0, 100 0, 100 100, 0 100, 0 0), (1 1, 1 10, 10 10, 10 1, 1 1) ), ((200 200, 200 250, 250 250, 250 200, 200 200)) )");
  }

  public void testGeometryCollection() throws ParseException {
    runTest("GEOMETRYCOLLECTION ( POINT ( 1 1), LINESTRING (0 0, 10 10), POLYGON ((0 0, 100 0, 100 100, 0 100, 0 0)) )");
  }

  public void testNestedGeometryCollection() throws ParseException {
    runTest("GEOMETRYCOLLECTION ( POINT (20 20), GEOMETRYCOLLECTION ( POINT ( 1 1), LINESTRING (0 0, 10 10), POLYGON ((0 0, 100 0, 100 100, 0 100, 0 0)) ) )");
  }

  // empty atomic geometries are not supported in GeoJSON
  
  public void testMultiPointEmpty() throws ParseException {
    runTest("MULTIPOINT EMPTY");
  }

  public void testMultiLineStringEmpty() throws ParseException {
    runTest("MULTILINESTRING EMPTY");
  }

  public void testMultiPolygonEmpty() throws ParseException {
    runTest("MULTIPOLYGON EMPTY");
  }

  public void testGeometryCollectionEmpty() throws ParseException {
    runTest("GEOMETRYCOLLECTION EMPTY");
  }

  private void runTest(String wkt) throws ParseException {
    Geometry expected = read(wkt);
    String json = this.geoJsonWriter.write(expected);
    Geometry result = this.geoJsonReader.read(json);
    checkEqual(result, expected);
  }

}
