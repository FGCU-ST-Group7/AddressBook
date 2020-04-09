import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.platform.engine.discovery.ClassNameFilter.includeClassNamePatterns;
import static org.junit.platform.engine.discovery.DiscoverySelectors.selectClass;
import static org.junit.platform.engine.discovery.DiscoverySelectors.selectPackage;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.TestPlan;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;
import org.junit.platform.launcher.listeners.TestExecutionSummary;
import org.junit.platform.launcher.listeners.TestExecutionSummary.Failure;
import org.mockito.Mock;
import org.testng.Assert;

public class TestRunner {

  private Person person;
  @Mock
  private AddressBook mockAddressBook;

  @BeforeEach
  public void setUp() {
    person = new Person("Johnny", "Appleseed", "555 AppleTree Road",
        "Bonita Springs", "FL", "33908", "(239) 999-9999");

    mockAddressBook = mock(AddressBook.class);
  }

  @AfterEach
  public void TearDown() {
    person = null;
    mockAddressBook = null;
  }

  @Test
  private void addTest() {
    when(mockAddressBook.get(0)).thenReturn(person);
    mockAddressBook.get(0);
    verify(mockAddressBook, atLeastOnce()).get(0);
  }

  public static void main(String[] args) {
    final LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
        .selectors(
            selectClass(TestRunner.class))
        .build();

    final Launcher launcher = LauncherFactory.create();

    final SummaryGeneratingListener listener = new SummaryGeneratingListener();

    launcher.registerTestExecutionListeners(listener);
    launcher.execute(request);

    TestExecutionSummary summary = listener.getSummary();
    System.out.println("getTestsFoundCount() : " + summary.getTestsFoundCount());
    List<Failure> failures = summary.getFailures();
    System.out.println("getTestsSucceededCount() : " + summary.getTestsSucceededCount());
    failures.forEach(failure -> System.out.println("failure -" + failure.getException()));
  }

  @Test
  void exceptionTesting() {
    Executable closureContainingCodeToTest = () -> {
      throw new IllegalArgumentException("a message");
    };
    Throwable throwable = assertThrows(IllegalArgumentException.class, closureContainingCodeToTest,
        "a message");
    assertEquals("a message", throwable.getMessage());
  }
}
