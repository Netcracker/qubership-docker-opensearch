package com.netcracker.opensearch;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;
import org.opensearch.action.support.ActionFilter;
import org.opensearch.client.Client;
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
import org.opensearch.cluster.service.ClusterService;
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
import org.opensearch.core.xcontent.NamedXContentRegistry;
import org.opensearch.env.Environment;
import org.opensearch.env.NodeEnvironment;
import org.opensearch.plugins.ActionPlugin;
import org.opensearch.plugins.Plugin;
import org.opensearch.repositories.RepositoriesService;
import org.opensearch.script.ScriptService;
import org.opensearch.threadpool.ThreadPool;
import org.opensearch.watcher.ResourceWatcherService;

public class CustomOpenSearchPlugin extends Plugin implements ActionPlugin {

  private volatile Client client;
  private volatile ThreadPool threadPool;

  @Override
  public List<ActionFilter> getActionFilters() {
    List<ActionFilter> filters = new ArrayList<>(1);
    ActionFilter securityFilter = new IsmSecurityFilter(threadPool, client);
    filters.add(Objects.requireNonNull(securityFilter));
    return filters;
  }

  @Override
  public Collection<Object> createComponents(Client client, ClusterService clusterService,
      ThreadPool threadPool, ResourceWatcherService resourceWatcherService,
      ScriptService scriptService, NamedXContentRegistry namedXContentRegistry,
      Environment environment, NodeEnvironment nodeEnvironment,
      NamedWriteableRegistry namedWriteableRegistry,
      IndexNameExpressionResolver indexNameExpressionResolver,
      Supplier<RepositoriesService> repositoriesServiceSupplier) {
    this.threadPool = threadPool;
    this.client = client;
    return super.createComponents(client, clusterService, threadPool, resourceWatcherService,
        scriptService, namedXContentRegistry, environment, nodeEnvironment, namedWriteableRegistry,
        indexNameExpressionResolver, repositoriesServiceSupplier);
  }
}
