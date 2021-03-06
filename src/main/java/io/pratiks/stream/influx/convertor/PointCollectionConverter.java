package io.pratiks.stream.influx.convertor;

import org.influxdb.dto.Point;
import org.springframework.core.convert.converter.Converter;

import java.util.List;

public interface PointCollectionConverter<T> extends Converter<T, List<Point>> {

}