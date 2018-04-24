package pt.iscte.es2.decisionsoft.data;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

import pt.iscte.es2.decisionsoft.domain.Criteria;

/**
 * Writes rules and its weights to a file
 */
public class CriteriaWriter {

	private final Writer writer;

	/**
	 * RulesWriter constructor
	 *
	 * @param writer writer to use
	 */
	public CriteriaWriter(Writer writer) {
		this.writer = writer;
	}

	/**
	 * Writes rules and weights to a {@link Writer}.
	 *
	 * @param weightedRules rules and weights being written
	 * @throws IOException when writing or closing the writer
	 */
	public void write(List<Criteria> criterias) throws IOException {
		final BufferedWriter bw = new BufferedWriter(writer);
		try {
			for (int i = 0; i != criterias.size(); i++) {
				bw.write(criterias.get(i).getName() + "\t" + criterias.get(i).getValue() + "\n");
			}
		} finally {
			bw.close();
		}
	}
}

