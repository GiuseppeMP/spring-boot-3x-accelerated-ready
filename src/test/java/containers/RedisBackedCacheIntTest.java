package containers;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

/**
 * RedisBackedCacheIntTest
 */
@Testcontainers
public class RedisBackedCacheIntTest {


    // container {
    @Container
    public GenericContainer redis =
            new GenericContainer(DockerImageName.parse("redis:5.0.3-alpine"))
                    .withExposedPorts(6379);

    private Map<String, Integer> underTest;

    @BeforeEach
    public void setUp() {
        final String address = redis.getHost();
        final Integer port = redis.getFirstMappedPort();

        underTest = new HashMap<>();
        underTest.put(address, port);
    }

    @Test
    public void testSimplePutAndGet() {
        underTest.put("test", 1);
        final Integer retrieved = underTest.get("test");
        assertThat(retrieved).isEqualTo(1);
    }
}
