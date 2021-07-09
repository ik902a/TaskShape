package by.epam.learn.reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.epam.learn.exception.ShapeException;

public class ShapeFileReader {
	public static Logger log = LogManager.getLogger();
	
	public List<String> readFromFile (String filename) throws ShapeException {
		Path path = Paths.get(filename);
		if (!Files.exists(path) && Files.isDirectory(path) && !Files.isReadable(path)) {
			log.error("file not read");
			throw new ShapeException("file not read");
		}
		List<String> result;
		try (Stream<String> streamLines = Files.lines(path)) {
			result = streamLines.collect(Collectors.toList());
		} catch (IOException e) {
			log.error("file " + filename + " read error");
			throw new ShapeException("file " + filename + " read error", e);
		}
		log.info("read data from file: " + filename);
		return result;
	}
}
