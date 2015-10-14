/*
 * Licensed to Elasticsearch under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Elasticsearch licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.elasticsearch.search.profile;

import org.elasticsearch.search.SearchShardTarget;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Public interface for accessing the profile results from a search request.
 * This contains the results for all shards in the request.
 */
public interface ProfileResults {

    /**
     * Returns the profile results as a map, where the Shard is the key and the
     * profiled results are the value
     */
    Map<SearchShardTarget, List<ProfileResult>> queryProfilesAsMap();

    /**
     * Returns the collector results as a map, where the Shard is the key and the
     * profiled collectors are the value
     */
    Map<SearchShardTarget, CollectorResult> collectorProfilesAsMap();

    /**
     * Returns an entrySet over the map to facilitate iterating
     */
    Set<Map.Entry<SearchShardTarget, List<ProfileResult>>> getQueryProfilesEntrySet();

    /**
     * Returns an entrySet over the map to facilitate iterating
     */
    Set<Map.Entry<SearchShardTarget, CollectorResult>> getCollectorProfilesEntrySet();

    /**
     * Returns a collection of ProfileResults.  Note: calling this
     * method does not tell you which shard is associated with which result
     */
    Collection<List<ProfileResult>> queryProfilesAsCollection();

    /**
     * Returns a collection of ProfileResults.  Note: calling this
     * method does not tell you which shard is associated with which result
     */
    Collection<CollectorResult> collectorProfilesAsCollection();


}